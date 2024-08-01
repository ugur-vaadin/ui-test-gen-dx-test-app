import { TextField } from '@vaadin/react-components/TextField.js';
import { TextArea } from '@vaadin/react-components/TextArea';
import { Select } from '@vaadin/react-components/Select';
import { NumberField } from '@vaadin/react-components/NumberField';
import { RadioGroup } from '@vaadin/react-components/RadioGroup';
import { RadioButton } from '@vaadin/react-components/RadioButton';
import { HorizontalLayout } from '@vaadin/react-components/HorizontalLayout';
import { EmailField } from '@vaadin/react-components/EmailField';
import { PasswordField } from '@vaadin/react-components/PasswordField';
import { TabSheet } from '@vaadin/react-components/TabSheet';
import { Tabs } from '@vaadin/react-components/Tabs';
import { Tab } from '@vaadin/react-components/Tab';
import { Scroller } from '@vaadin/react-components/Scroller';
import { VerticalLayout } from '@vaadin/react-components/VerticalLayout';
import { Checkbox } from '@vaadin/react-components/Checkbox';
import { Button } from '@vaadin/react-components/Button';

import './person.css';
import {ViewConfig} from "@vaadin/hilla-file-router/types.js";

export const config: ViewConfig = {
  menu: { order: 3, icon: 'line-awesome/svg/smile-solid.svg' },
  title: 'Person React',
};

export default function PersonFormView() {
  const items = [
    {
      label: 'Finland',
      value: 'fi',
    },
    {
      label: 'Turkey',
      value: 'tu',
    },
    {
      label: 'Hungary',
      value: 'hu',
    },
    {
      label: 'Spain',
      value: 'es',
    },
    {
      label: 'Poland',
      value: 'pl',
    },
    {
      component: 'hr',
    },
    {
      label: 'Other',
      value: 'other',
    },
  ];
  return (
    <VerticalLayout className={'person-form'}>
      <h2>Contact details</h2>
      <VerticalLayout>
        <HorizontalLayout theme={'spacing'}>
          <TextField label={'First name'} />
          <TextField label={'Middle name'} />
          <TextField label={'Last name'} />
        </HorizontalLayout>
        <HorizontalLayout theme={'spacing'}>
          <TextField label={'Phone number'} />
          <Select label={'Country'} items={items} />
        </HorizontalLayout>
      </VerticalLayout>
      <h2>Personal details</h2>
      <VerticalLayout>
        <HorizontalLayout>
          <RadioGroup label="Favourite animal">
            <RadioButton value="dog" label="Dog" />
            <RadioButton value="cat" label="Cat" />
            <RadioButton value="hamster" label="Hamster" />
          </RadioGroup>
          <NumberField label={'Age'} stepButtonsVisible min={18} max={99} />
        </HorizontalLayout>
        <HorizontalLayout>
          <TextArea label={'Few words about yourself'} />
        </HorizontalLayout>
      </VerticalLayout>
      <h2>Account</h2>
      <span>If you want to create account fill fields below</span>
      <HorizontalLayout theme="spacing">
        <EmailField label={'Email'} />
        <PasswordField label={'Password'} />
      </HorizontalLayout>
      <h2>Terms and conditions</h2>
      <TabSheet theme={'centered small bordered'}>
        <Tabs slot="tabs">
          <Tab id="terms">Terms of Service</Tab>
          <Tab id="privacy">Privacy Policy</Tab>
        </Tabs>

        <div {...{ tab: 'terms' }}>
          <Scroller scrollDirection={'vertical'} style={{ height: '150px' }}>
            <p>
              Sed semper, magna elementum maximus consequat, arcu nulla viverra diam, eu fringilla diam eros at quam.
              Nulla vitae tortor lacus. Mauris pharetra felis non lacus congue venenatis. Donec sollicitudin arcu at
              auctor iaculis. Cras sed purus enim. Nullam aliquam semper finibus. Nam blandit purus in convallis luctus.
              Aliquam tortor tellus, gravida in elit nec, fermentum sollicitudin tortor. Aliquam imperdiet quam ante, ac
              tempor turpis consequat eu.{' '}
            </p>
          </Scroller>
        </div>
        <div {...{ tab: 'privacy' }}>
          <Scroller scrollDirection={'vertical'} style={{ height: '150px' }}>
            <p>
              Nunc tempor, nisi eu lacinia laoreet, purus elit viverra augue, in gravida leo arcu vel turpis. Ut
              ultricies tempor venenatis. Aliquam volutpat mollis elit, vel accumsan ipsum placerat sed. Mauris
              ullamcorper feugiat semper. Suspendisse potenti. Nulla mollis, orci id finibus condimentum, mi tellus
              molestie mauris, vitae sollicitudin purus tortor posuere purus. Nulla eu nisi urna. Pellentesque lectus
              lorem, placerat et leo ut, aliquet consequat nisl. Phasellus suscipit nulla eget magna ullamcorper, eu
              auctor velit dapibus. Cras at lorem viverra, gravida odio vel, mattis nibh. Curabitur vulputate turpis
              eget dignissim suscipit. Ut dictum auctor ornare.{' '}
            </p>
          </Scroller>
        </div>
      </TabSheet>
      <h2>Accept and save</h2>
      <VerticalLayout>
        <Checkbox label={'I accept terms above and hereby promise to download and use Vaadin and provide feedback'} />
        <HorizontalLayout theme={'spacing padding'}>
          <Button>Cancel</Button>
          <Button theme={'primary'}>Save</Button>
        </HorizontalLayout>
      </VerticalLayout>
    </VerticalLayout>
  );
}
